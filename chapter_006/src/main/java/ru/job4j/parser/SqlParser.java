package ru.job4j.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class SqlParser implements Process {
    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);
    private String name;
    private String text;
    private String link;
    private String time;

    @Override
    public List<Vacancy> parse() {
        List<Vacancy> list = new LinkedList<>();
        int page = getPage("http://www.sql.ru/forum/job-offers/");
        LOGGER.info("Find the total number of pages forum" + page);
        for (int i = 1; i <= page; i++) {
            Document document = null;
            try {
                document = Jsoup.connect(String.format("http://www.sql.ru/forum/job-offers/%s", i)).get();
                Elements rowsOfTable = document.select("tr");
                for (Element element : rowsOfTable) {
                    Elements description = element.select("td[class=postslisttopic]");
                    LOGGER.info("find the job description ");
                    time = element.select("td[style].altCol").text();
                    if (!time.isEmpty() && !time.startsWith("вчера") && !time.startsWith("сегодня")) {
                        String[] dateTime = time.split(",");
                        Date parsingDate = parseDate(dateTime[0]);
//                    проверяем дату нашей вакансии, если она раньше 1 января 2019 года
                        Date date = parseDate("01 янв 19");
                        if (parsingDate.after(date)) {
                            // находим описание вакансии и ссылку
                            if (description.size() != 0) {
                                Elements e2 = description.select("a");
                                name = e2.get(0).text();
                                link = e2.get(0).attr("href");
                                if (name.toLowerCase().contains("java")
                                        && !(name.toLowerCase().contains("javascript")
                                        || name.toLowerCase().contains("java script"))) {
                                    Document doc2 = null;
                                    try {
                                        doc2 = Jsoup.connect(link).get();
                                        text = doc2.select("td[class=msgBody]").text();
                                        list.add(new Vacancy(name, text, link));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private static Date parseDate(String stringDate) {
        Locale locale = new Locale("ru");
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        String[] shortMonths = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        dateFormatSymbols.setShortMonths(shortMonths);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yy", locale);
        simpleDateFormat.setDateFormatSymbols(dateFormatSymbols);
        Date date = null;
        try {
            date = simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static int getPage(String address) {
        Document doc = null;
        int pageCount = 0;
        try {
            doc = Jsoup.connect(String.format("http://www.sql.ru/forum/job-offers/")).get();
            Elements tablePages = doc.select("table[class=sort_options]");
            Elements countPages = tablePages.select("td[style=text-align:left]");
            pageCount = Integer.valueOf(countPages.select("a").last().text());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pageCount;
    }
}


