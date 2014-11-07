/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.qbi.seriescalendar.web.model.Day;
import org.qbi.seriescalendar.web.model.Series;
import org.qbi.seriescalendar.web.model.xml.Schedule;
import org.qbi.seriescalendar.web.model.xml.ScheduleDay;

/**
 *
 * @author Qbi
 */
public class ScheduleConverter {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ScheduleConverter.class);
    
    public static StreamedContent convertToXml(List<Day> daysOfWeek) {

        try {
            File outFile = File.createTempFile("tempfile", ".tmp");
            Schedule schedule = new Schedule();
            List<ScheduleDay> dayList = new ArrayList<>();
            for (Day day : daysOfWeek) {
                ScheduleDay sDay = new ScheduleDay();
                sDay.setName(day.getDay());
                List<String> titles = new ArrayList<>();
                for (Series series : day.getSeriesList()) {
                    titles.add(series.getTitle());
                }
                sDay.setTitle(titles);
                dayList.add(sDay);
            }
            schedule.setDay(dayList);

            JAXBContext jAXBContext = JAXBContext.newInstance(Schedule.class);

            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(schedule, outFile);
            //marshaller.marshal(schedule, System.out);

            InputStream stream = new FileInputStream(outFile);
            StreamedContent file = new DefaultStreamedContent(stream, "application/xml", "schedule.xml");
            return file;

        } catch (JAXBException ex) {
            Logger.getLogger(ScheduleConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScheduleConverter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static List<Day> convertToList(UploadedFile file) {

        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(Schedule.class);

            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            Schedule schedule = (Schedule) unmarshaller.unmarshal(file.getInputstream());
            
            List<Day> days = new ArrayList<>();
            
            for (ScheduleDay sDay : schedule.getDay()) {
                
                String day = sDay.getName();
                
                List<Series> seriesList = new ArrayList<>();
                for (String s : sDay.getTitle()) {
                    seriesList.add(new Series(day, s));
                }
                               
                days.add(new Day(day, seriesList));
            }
            
            return days;

        } catch (JAXBException ex) {
            Logger.getLogger(ScheduleConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScheduleConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
