package com.finding.spiderCore.crawldb;

import com.finding.spiderCore.entities.CrawlDatum;
import com.finding.spiderCore.entities.CrawlDatums;
import com.finding.spiderCore.spiderConfig.DefaultConfigImp;

public abstract class DBManager extends DefaultConfigImp implements Injector, SegmentWriter {

    private Generator generator;
    private DataBase dataBase;

    public DBManager(Generator generator){
            setGenerator(generator);
            setDataBase(generator.getDataBase());
        }
    public abstract boolean isDBExists();

    public abstract void clear() throws Exception;

    public abstract void open() throws Exception;

    public abstract void close() throws Exception;

    public abstract void inject(CrawlDatum datum, boolean force) throws Exception;

    public abstract void inject(CrawlDatums datums, boolean force) throws Exception;

    public abstract void merge() throws Exception;

    @Override
    public void inject(CrawlDatum datum) throws Exception {
        inject(datum, false);
    }

//    public void inject(CrawlDatums datums, boolean force) throws Exception {
//        for (CrawlDatum datum : datums) {
//            inject(datum, force);
//        }
//    }

    public void inject(CrawlDatums datums) throws Exception {
        inject(datums, false);
    }

    public void inject(Iterable<String> links, boolean force) throws Exception {
        CrawlDatums datums = new CrawlDatums(links);
        inject(datums, force);
    }

    public void inject(Iterable<String> links) throws Exception {
        inject(links, false);
    }

    public void inject(String url, boolean force) throws Exception {
        CrawlDatum datum = new CrawlDatum(url);
        inject(datum, force);
    }

    public void inject(String url) throws Exception {
        CrawlDatum datum = new CrawlDatum(url);
        inject(datum);
    }

    public Generator getGenerator() {
        return generator;
    }
    public void setGenerator(Generator generator) {
        this.generator = generator;
    }
    public DataBase getDataBase() {
        return dataBase;
    }
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
