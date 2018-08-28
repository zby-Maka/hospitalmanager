package com.dyhc.hospitalmanager.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 批量导入Excel数据util
 */
public class ImportExcelUtil {

    private final static String excel2003=".xls";//2003版本的excel
    private final static String excel2007=".xlsx";//2007级以上版本的excel

    /**
     * 获取IO中的输入流中的数据，组装成List<List<object>>集合
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public List<List<Object>> getBankListByExcel(InputStream in,String fileName) throws Exception{
        //创建存放excel数据对象集合
        List<List<Object>> list=null;
        //创建excel工作薄
        Workbook workbook=this.getWorkbook(in,fileName);
        if(workbook==null){
            throw new Exception("创建的excel工作薄为空！！！");
        }
        //创建表空间对象
        Sheet sheet=null;
        //创建行对象
        Row row=null;
        //单元格对象
        Cell cell=null;

        list=new ArrayList<List<Object>>();

        //获取表空间个数
        int s=workbook.getNumberOfSheets();
        //遍历所有的表空间
        for(int i=0;i<s;i++){
            //循环获取表空间
            sheet=workbook.getSheetAt(i);
            if(sheet==null){
                continue;
            }
            //获取表空间中最后一行的行号
            int lastrownumber=sheet.getLastRowNum();
            //遍历当前表空间的所有行
            for(int a=sheet.getFirstRowNum();a<=lastrownumber;a++){
                row=sheet.getRow(a);
                if(row==null||row.getFirstCellNum()==a){
                    continue;
                }

                //遍历所有的列
                List<Object> column=new ArrayList<Object>();
                for(int b=row.getFirstCellNum();b<row.getLastCellNum();b++){
                    cell=row.getCell(b);
                    column.add(this.getCellValue(cell));
                }
                list.add(column);
            }
        }
        return list;
    }


    /**
     * 根据文件后缀，自适应上传文件的版本
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream in, String fileName) throws Exception{
        Workbook workbook=null;
        //截取文件后缀
        String fileType=fileName.substring(fileName.lastIndexOf("."));
        if(excel2003.equals(fileType)){
            //实例化excel2003的工作薄，并传入文件流
            workbook=new HSSFWorkbook(in);
        }else if(excel2007.equals(fileType)){
            //实例化excel2007及以上版本的工作薄，并传入文件流
            workbook=new XSSFWorkbook(in);
        }else {
            throw  new Exception("文件格式解析错误！！！");
        }
        return workbook;
    }


    /**
     *对表格中的数值进行格式化
     * @param cell
     * @return
     */
    public Object getCellValue(Cell cell){
        Object value=null;
        //格式化数字是字符串类型的字符
        DecimalFormat dfstring=new DecimalFormat("0");
        //格式化日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //格式化数字
        DecimalFormat dfnumber=new DecimalFormat("0.00");

        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                value=cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value=dfstring.format(cell.getNumericCellValue());
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    value=sdf.format(cell.getDateCellValue());
                }else {
                    value=dfnumber.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value=cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value="";
                break;
                default:
                    break;
        }
        return value;
    }
}
