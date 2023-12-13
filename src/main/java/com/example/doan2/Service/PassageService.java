package com.example.doan2.Service;

import com.example.doan2.Dto.PassageDto;
import com.example.doan2.Entities.PassageEntity;
import com.example.doan2.Repository.PassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassageService {

    @Autowired
    PassageRepository passageRepository;
    public PassageEntity saveAndReturnId(PassageDto passageDto) throws IOException {
        PassageEntity passage = new PassageEntity();
        passage.setPassage1(passageDto.getPassage1());
        passage.setPassage2(passageDto.getPassage2());
        passage.setPassage3(passageDto.getPassage3());

        return passageRepository.save(passage);
    }
    public PassageEntity findById(Integer id){
        Optional<PassageEntity> passageEntityOptional = passageRepository.findById(id);
        return passageEntityOptional.orElse(null);
    }
    public List<PassageEntity> findAll(){
        return  passageRepository.findAll();
    }

    public List<String> findContentByPassage(Integer id, int passageNumber) {
        List<String> contents = new ArrayList<>();
        List<Object[]> resultList = passageRepository.findContentAndPassageByReadingIdAndPassage(id, passageNumber);
        for (Object[] result : resultList) {
            String content = (String) result[0];
            contents.add(content);
        }
        return contents;
    }

    public List<String> findTypeByPassage(Integer id, int passageNumber) {
        List<String> types = new ArrayList<>();
        List<Object[]> resultList = passageRepository.findContentAndPassageByReadingIdAndPassage(id, passageNumber);
        for (Object[] result : resultList) {
            String type = (String) result[3];
            types.add(type);
        }
        return types;
    }
    public List<Integer> findNumber(Integer id, int passageNumber) {
        List<Integer> nums = new ArrayList<>();
        List<Object[]> resultList = passageRepository.findContentAndPassageByReadingIdAndPassage(id, passageNumber);
        for (Object[] result : resultList) {
            Integer num = (Integer) result[4];
            nums.add(num);
        }
        return nums;
    }
    public String[][] option(Integer id,int passageNumber){
        List<Object[]> resultList = passageRepository.findContentAndPassageByReadingIdAndPassage(id, passageNumber);
        String a[][]=new String[resultList.size()][4];
        for(int i=0;i<resultList.size();i++){
            for(int j=0;j<4;j++){
                    a[i][j]= String.valueOf(resultList.get(i)[5+j]);
            }
        }
//        for(int i=0;i<resultList.size();i++){
//            for(int j=0;j<4;j++){
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
        return a;
    }
    public String passage(Integer id, int passageNumber) {
        String passage = "";
        List<Object[]> resultList = passageRepository.findContentAndPassageByReadingIdAndPassage(id, passageNumber);
        for (Object[] result : resultList) {
            passage = (String) result[1];
            break;
        }



        return passage;
    }
    public List<String> findCorrect(Integer id, int passageNumber) {
        List<String> correct = new ArrayList<>();
        List<Object[]> resultList = passageRepository.findContentAndPassageByReadingIdAndPassage(id, passageNumber);
        for (Object[] result : resultList) {
            String num = (String) result[9];
            correct.add(num);
        }
        return correct;
    }
    public String generateOutputWithInputs(List<String> content, List<String> type,List<Integer>nums,String [][]option,int passageNumber) {
        StringBuilder output = new StringBuilder();

        int i = 0;
        while (i < content.size()) {
            String temp = type.get(i);
            output.append("<h3>De bai: ").append(type.get(i)).append("</h3><br>");

            int k;
            for (k = i; k < type.size(); k++) {
                if (!type.get(k).equals(temp)) {
                    break;
                }
                output.append("Question: ").append(nums.get(k)).append(" "+content.get(k)).append("<br>");
                if (!String.valueOf(option[k][0]).equals("null")) {
                    output.append("<input type=\"hidden\" name=\"input_" + passageNumber + "_" + k + "_placeholder\" />"); // Add hidden field as a placeholder
                    output.append("<input type=\"radio\" name=\"input_" + passageNumber + "_" + k + "\" value=\"A\"  title=\"" + option[k][0] + "\" data-questionIndex=\"" + nums.get(k) + "\" />Option A: " + option[k][0] + "</label><br>");
                    output.append("<input type=\"radio\" name=\"input_" + passageNumber + "_" + k + "\" value=\"B\" title=\"" + option[k][1] + "\" data-questionIndex=\"" + nums.get(k) + "\" />Option B: " + option[k][1] + "</label><br>");
                    output.append("<input type=\"radio\" name=\"input_" + passageNumber + "_" + k + "\" value=\"C\" title=\"" + option[k][2] + "\" data-questionIndex=\"" + nums.get(k) + "\" />Option C: " + option[k][2] + "</label><br>");
                    output.append("<input type=\"radio\" name=\"input_" + passageNumber + "_" + k + "\" value=\"D\" title=\"" + option[k][3] + "\" data-questionIndex=\"" + nums.get(k) + "\" />Option D: " + option[k][3] + "</label><br>");
                }
                else {
                    output.append("<input type=\"text\" name=\"input_" + passageNumber + "_" + k  + "\" data-questionIndex=\"" + nums.get(k) + "\" /><br>");
                }
            }

            i = k;
        }

        return output.toString();
    }


}
