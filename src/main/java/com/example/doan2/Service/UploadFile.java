package com.example.doan2.Service;

import com.example.doan2.Entities.PassageEntity;
import com.example.doan2.Entities.ReadingQuesEntity;
import com.example.doan2.Repository.PassageRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class UploadFile {
    @Autowired
    PassageRepository passageRepository;

    public List<ReadingQuesEntity> getQuestionFromExel(InputStream inputStream) {
        List<ReadingQuesEntity> questions = new ArrayList<>();
        try {
            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workBook.getSheet("question");
            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                ReadingQuesEntity quesEntity = new ReadingQuesEntity();
                int cellIndex = 0;
// khả năng do lỗi has.next

                for ( cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    String cellValue;

                    if (cell == null || cell.getCellType() == CellType.BLANK || cell.getCellType() == CellType.ERROR) {
                        cellValue = null;
                    } else {
                        // Format cell value as string
                        DataFormatter formatter = new DataFormatter();
                        cellValue = formatter.formatCellValue(cell).trim();
                    }

                    switch (cellIndex) {
                        case 0:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                quesEntity.setNumber_question((int) cell.getNumericCellValue());
                            }
                            break;
                        case 1:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                quesEntity.setPassage((int) cell.getNumericCellValue());
                            }
                            break;
                        case 2:
                            if (cellValue != null && !cellValue.isEmpty()) {

                                quesEntity.setType(cellValue);
                            }                            break;
                        case 3:
                            if (cellValue != null && !cellValue.isEmpty()) {

                                quesEntity.setContent(cellValue);
                            }  break;
                        case 4:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                quesEntity.setA(cellValue);
                            }  break;
                        case 5:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                quesEntity.setB(cellValue);
                            }  break;
                        case 6:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                quesEntity.setC(cellValue);
                            } break;
                        case 7:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                quesEntity.setD(cellValue);
                            } break;
                        case 8:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                quesEntity.setCorrect(cellValue);
                            }  break;
                        case 9:
                            if (cellValue != null && !cellValue.isEmpty()) {
                                PassageEntity passage = passageRepository.getById((int) cell.getNumericCellValue());
                                quesEntity.setPassageEntity(passage);
                            }
                            break;
                        default:
                            break;
                    }
                }

                questions.add(quesEntity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return questions;

    }}
