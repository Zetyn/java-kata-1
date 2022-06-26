package org.echocat.kata.java.part1.models;

import java.time.LocalDate;

public interface ChapterNameAndNumberDTO {
     int getChapterNumber();
     int getVolumeNumber();
     String getName();
     LocalDate getDateAdded();
}
