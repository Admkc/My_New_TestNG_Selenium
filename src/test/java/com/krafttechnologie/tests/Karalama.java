package com.krafttechnologie.tests;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Karalama extends TestBase{
    @DataProvider
    public Object[][] userDataKul(){

        ExcelUtil qateam=new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");

        String [][] dataarri=qateam.getDataArrayWithoutFirstRow();

        return dataarri;
    }
    @Test(dataProvider = "userDataKul")
    public void logintestileDDF(String eml,String psp,String name){

        LoginPages loginPages=new LoginPages();
        DashboardPage dashboardPage=new DashboardPage();

        loginPages.loginWithParameters(eml,psp);

        String actName= dashboardPage.getUserName();
        String exp=name;

        Assert.assertEquals(actName,exp);






    }



}
