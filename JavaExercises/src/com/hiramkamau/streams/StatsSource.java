package com.hiramkamau.streams;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

public class StatsSource {
    private List<CountryStats> stats;
    
//    public List<CountryStats> getStats() {
//        if (stats == null) {
//            File f; //Get CSV file containing data
//            Reader in = new FileReader(f);
//            CSVFormat csvf = CSVFormat
//                .DEFAULT
//                .builder()
//                .setHeader()
//                .setSkipHeaderRecord(true)
//                .build();
//            
//            Spliterator split = csvf.parse(in)
//                .splitIterator();
//            
//            stats = StreamSupport
//                // Set `true` to make stream parallel
//                // Set `false` to make sequential
//                .stream(split, false)
//                .map(StatsSource::toStats)
//                .collect(toList());                
//        }
//        
//        return stats;
//    }
    
//    public static CountryStats toStats(CSVRecord r) {
//        // Constructor...
//    }
}

