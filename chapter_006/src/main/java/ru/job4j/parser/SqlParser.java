package ru.job4j.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SqlParser implements Process {
    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);
    private String name;
    private String text;
    private String link;
    private String time;

    @Override
    public List<Vacancy> parse() {
            List<Vacancy> list = new LinkedList<>();
            try {
                Document doc = Jsoup.connect(String.format("http://www.sql.ru/forum/job-offers/")).get();
                Elements tablePages = doc.select("table[class=sort_options]");
                Elements countPages = tablePages.select("td[style=text-align:left]");
                int page = Integer.valueOf(countPages.select("a").last().text());
                LOGGER.info("Find the total number of pages forum" + page);
                for (int i = 1; i <= page; i++) {
                    Document document = Jsoup.connect(String.format("http://www.sql.ru/forum/job-offers/%s", i)).get();
                    for (Element el : document.select("tr")) {
                        Elements description = el.select("td.postslisttopic");
                        LOGGER.info("find the job description ");
                        time = el.select("td[style].altCol").text();
//                    проверяем дату нашей вакансии, если она раньше 1 января 2019 года
                        if (!time.equals("вчера") || !time.equals("сегодня")) {
                            SimpleDateFormat df = new SimpleDateFormat("yyyy");
                            Date parsingDate;
                            try {
                                parsingDate = df.parse(time);
                                Date date = new Date("2019-01-01");
                                if (parsingDate.after(date)) {
                                    if (description.size() != 0) {
//                         находим описание вакансии и ссылку
                                        Elements e2 = description.select("a");
                                        name = e2.get(0).text();
                                        link = e2.get(0).attr("href");
                                        if (name.toLowerCase().contains("java")
                                                && !(name.toLowerCase().contains("javascript")
                                                || name.toLowerCase().contains("java script"))) {
                                            Document doc2 = Jsoup.connect(link).get();
                                            text = doc2.select("td.msgBody").text();
                                            list.add(new Vacancy(name, text, link));
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                LOGGER.error("Parsing date error", e);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LOGGER.error("Parsing forum error", e);
            }
            return list;
        }
    }

