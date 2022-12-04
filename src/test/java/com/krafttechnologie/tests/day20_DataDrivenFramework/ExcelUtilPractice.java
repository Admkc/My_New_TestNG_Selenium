package com.krafttechnologie.tests.day20_DataDrivenFramework;

import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void readExcelFile() {
        /**
         Excel util den bir obje olusturulacak,obje 2 argüman alacak.
         dosyanın pathi ile calisma yapacagimiz sayfanin adı olacak.
         */

        //önce satir(row) sayisini bulalım.

        ExcelUtil qaTeam3=new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");

        System.out.println("qaTeam3.rowCount() = " + qaTeam3.rowCount());

        //column(sütun) sayisini bulalım.

        System.out.println("qaTeam3.columnCount() = " + qaTeam3.columnCount());

        //column name

        System.out.println("qaTeam3.getColumnsNames() = " + qaTeam3.getColumnsNames());

        //qateam3 objesine data olarak atanan degerleri liste olarak cagirma

        List<Map<String ,String >> datalist=qaTeam3.getDataList();

        System.out.println("datalist = " + datalist);

        //row olarak cagirma

        for (Map<String ,String > row:qaTeam3.getDataList()){
            System.out.println("row = " + row);

        }
        // 2.satırı getirelim. indexten
        System.out.println("datalist.get(2) = " + datalist.get(2));

        System.out.println("datalist.get(2).get(\"Your Name\") = " + datalist.get(2).get("Your Name"));//Jhon Nash

        String [][] dataarray= qaTeam3.getDataArray();

        System.out.println("Arrays.deepToString(dataarray) = " + Arrays.deepToString(dataarray));
    }
}
