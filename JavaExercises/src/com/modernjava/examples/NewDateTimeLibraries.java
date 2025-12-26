package com.modernjava.examples;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class NewDateTimeLibraries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("df.format(date) - " + df.format(date));
		
		DateFormat df1 = new SimpleDateFormat("HH:mm:ss");
		System.out.println("df1.format(date) - " + df1.format(date));
		
		System.out.println("Calendar.getInstance().getTime() - " + Calendar.getInstance().getTime());
		
		
		// Java 8 classes
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate - " + localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime - " + localTime);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime - " + localDateTime);
//		df.format(date) - 23-09-2024
//		df1.format(date) - 18:06:18
//		Calendar.getInstance().getTime() - Mon Sep 23 18:06:18 IST 2024
//		localDate - 2024-09-23
//		localTime - 18:06:18.632248900
//		localDateTime - 2024-09-23T18:06:18.633249200
		
		System.out.println("localDate - " + localDate);
		localDate = LocalDate.ofYearDay(2020, 5);
		System.out.println("localDate 5th day of the year - " + localDate);
		localDate = LocalDate.ofYearDay(2020, 365);
		System.out.println("localDate 365th day of the year - " + localDate);

		localDate = LocalDate.of(2020, 8, 28);
		System.out.println("localDate 28 Aug 2020 - " + localDate);
		System.out.println("localDate.getMonth() - " + localDate.getMonth());
		System.out.println("localDate.getMonthValue() - " + localDate.getMonthValue());
		System.out.println("localDate.getDayOfMonth() - " + localDate.getDayOfMonth());
		System.out.println("localDate.getDayOfYear() - " + localDate.getDayOfYear());
		System.out.println("localDate.getDayOfWeek() - " + localDate.getDayOfWeek());
		
		System.out.println("Chrono fields");
		System.out.println("localDate.get(ChronoField.DAY_OF_YEAR) - " + localDate.get(ChronoField.DAY_OF_YEAR));
		
		System.out.println("localDate.plusDays(4) - " + localDate.plusDays(4));
		System.out.println("localDate.plusMonths(2) - " + localDate.plusMonths(2));
		System.out.println("localDate.plusWeeks(8) - " + localDate.plusWeeks(8));
		System.out.println("localDate.minusDays(3) - " + localDate.minusDays(3));
		System.out.println("localDate.minusWeeks(10) - " + localDate.minusWeeks(10));
		
		localTime = LocalTime.of(21, 51);
		System.out.println("LocalTime.of(21, 51) - " + localTime);
		localTime = LocalTime.of(21, 51, 18);
		System.out.println("LocalTime.of(21, 51, 18) - " + localTime);
		localTime = LocalTime.of(21, 51, 18, 12341234);
		System.out.println("LocalTime.of(21, 51, 18, 12341234) - " + localTime);
		
		System.out.println("localTime.get(ChronoField.HOUR_OF_AMPM) - " + localTime.get(ChronoField.HOUR_OF_AMPM));
		System.out.println("localTime.get(ChronoField.HOUR_OF_DAY) - " + localTime.get(ChronoField.HOUR_OF_DAY));
		System.out.println("localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM) - " + localTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));
		System.out.println("localTime.get(ChronoField.CLOCK_HOUR_OF_DAY) - " + localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));

		System.out.println("localTime - " + localTime);
		System.out.println("localTime.plusHours(23) - " + localTime.plusHours(23));
		System.out.println("localTime.plusMinutes(69) - " + localTime.plusMinutes(69));
		System.out.println("localTime.plusSeconds(99) - " + localTime.plusSeconds(99));
		System.out.println("localTime.plusNanos(123456789L) - " + localTime.plusNanos(123456789L));
		
		System.out.println("localTime.with(LocalTime.MIDNIGHT) - " + localTime.with(LocalTime.MIDNIGHT));
		
		System.out.println("localDateTime - " + localDateTime);
		System.out.println("localDateTime.plusHours(23) - " + localDateTime.plusHours(23));
		System.out.println("localDateTime.plusMinutes(69) - " + localDateTime.plusMinutes(69));
		System.out.println("localDateTime.plusSeconds(99) - " + localDateTime.plusSeconds(99));
		System.out.println("localDateTime.plusNanos(123456789L) - " + localDateTime.plusNanos(123456789L));
		
		System.out.println("\nlocalDateTime.toLocalDate() - " + localDateTime.toLocalDate());
		System.out.println("localDateTime.toLocalTime() - " + localDateTime.toLocalTime());
		System.out.println("\nlocalDateTime - " + localDateTime);
		System.out.println("LocalDateTime.of(LocalDate.now(), LocalTime.now()) - " + LocalDateTime.of(LocalDate.now(), LocalTime.now()));
		
		//duration between two localdatetime
		LocalDateTime localDateTime1 = LocalDateTime.now();
		LocalDateTime localDateTime2 = LocalDateTime.now().plusHours(3);
		Duration d = Duration.between(localDateTime1, localDateTime2);
		System.out.println("d.toNanos() - " + d.toNanos());
		System.out.println("d.toSeconds() - " + d.toSeconds());
		System.out.println("d.toMinutes() - " + d.toMinutes());
		System.out.println("d.toHours() - " + d.toHours());
		System.out.println("d.toDays() - " + d.toDays());
		
		d = Duration.ofHours(15);
		System.out.println("Duration.ofHours(15) - " + d);
		
		LocalTime localTime1 = LocalTime.now();
		LocalTime localTime2 = LocalTime.now().plusMinutes(45);
		System.out.println("Duration.between(localTime1, localTime2) - " + Duration.between(localTime1, localTime2));
		

		LocalDateTime localDateTime3 = LocalDateTime.now();
		LocalDateTime localDateTime4 = LocalDateTime.now().plusMinutes(4500);
		System.out.println("Duration.between(localDateTime3, localDateTime4) - " + Duration.between(localDateTime3, localDateTime4));
		
		//Instant
		Instant instant = Instant.now();
		System.out.println("instant.getNano() - " + instant.getNano());
		
		date.toInstant();
		
		Date dateSql = new Date(System.currentTimeMillis());
		
		//95
		System.out.println("\nZoneId.getAvailableZoneIds().stream().forEach()");
		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		
		System.out.println("ZonedDateTime.now() - "  + ZonedDateTime.now());
		System.out.println("ZonedDateTime.now(ZoneId.of(\"Europe/Monaco\")) - "  + ZonedDateTime.now(ZoneId.of("Europe/Monaco")));
		System.out.println("ZonedDateTime.now(ZoneId.of(\"Europe/London\")) - "  + ZonedDateTime.now(ZoneId.of("Europe/London")));
		
		//96 LocalDateTime to ZonedDateTime
		LocalDateTime ldt1 = LocalDateTime.now();
		System.out.println(ldt1);
		ZonedDateTime zdt1 = ldt1.atZone(ZoneId.of("America/New_York"));
		System.out.println(zdt1);
		
		System.out.println("ldt1.atOffset(ZoneOffset.ofHours(-10)) - " + ldt1.atOffset(ZoneOffset.ofHours(-10)));
		
		//97 Convert To LocalDateTime
		Date date11 = new Date();
		LocalDateTime ldt2 = date.toInstant().atZone(ZoneId.of("Europe/London")).toLocalDateTime();
		System.out.println(ldt2);
		ldt2 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println(ldt2);
		
	}

}

interface Zombie {
  Zombie zombie = () -> System.out.println("Stars!!!");
  void shoot();
}
