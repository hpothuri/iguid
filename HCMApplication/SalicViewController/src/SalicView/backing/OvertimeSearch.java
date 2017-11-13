package SalicView.backing;

import SalicView.backing.Utils.ADFUtils;

import SalicView.backing.Utils.JSFUtils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.IOException;

import java.io.InputStream;

import java.net.MalformedURLException;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.event.ActionEvent;

import javax.xml.bind.DatatypeConverter;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

//import oracle.cloud.storage.CloudStorage;
//import oracle.cloud.storage.CloudStorageConfig;
//
//import oracle.cloud.storage.CloudStorageFactory;

//import oracle.cloud.storage.CloudStorage;
//import oracle.cloud.storage.CloudStorageConfig;
//import oracle.cloud.storage.CloudStorageFactory;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;


public class OvertimeSearch {
    ViewObject variationSearchVo=ADFUtils.findIterator("XxhcmOvertimeHeadersAllVO1Iterator").getViewObject();
    private RichInputText it1;
    private RichTable t2;
    private RichInputText mgrItSearch;
    private RichTable mgrTable;


    public void onClickSearch(ActionEvent actionEvent) {
        if(it1.getValue()!=null){
            ViewCriteria vc=variationSearchVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("RequestNumber", "like %"+it1.getValue()+"%");
            vc.addRow(vcr);
            variationSearchVo.applyViewCriteria(vc);
            variationSearchVo.executeQuery();
        }else{
            ViewCriteria vc=variationSearchVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("RequestNumber", "");
            vc.addRow(vcr);
            variationSearchVo.applyViewCriteria(vc);
            variationSearchVo.executeQuery();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(t2);
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void onClickMgrDashSearchACL(ActionEvent actionEvent) {
        ViewObject mgrVo=ADFUtils.findIterator("XxQpActionHistoryTVO1Iterator").getViewObject();
        if(mgrItSearch.getValue()!=null){
            ViewCriteria vc=mgrVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("ApproverUserName", "like %"+mgrItSearch.getValue()+"%");
            vc.addRow(vcr);
            mgrVo.applyViewCriteria(vc);
            mgrVo.executeQuery();
        }else{
            ViewCriteria vc=mgrVo.createViewCriteria();
            ViewCriteriaRow vcr=vc.createViewCriteriaRow();
            vcr.setAttribute("ApproverUserName", "");
            vc.addRow(vcr);
            mgrVo.applyViewCriteria(vc);
            mgrVo.executeQuery();
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget(mgrTable);
    }

    public void setMgrItSearch(RichInputText mgrItSearch) {
        this.mgrItSearch = mgrItSearch;
    }

    public RichInputText getMgrItSearch() {
        return mgrItSearch;
    }

    public void setMgrTable(RichTable mgrTable) {
        this.mgrTable = mgrTable;
    }

    public RichTable getMgrTable() {
        return mgrTable;
    }

    public void fileACL(ActionEvent actionEvent) throws FileNotFoundException,
                                                        MalformedURLException {
     /*   CloudStorageConfig myConfig = new CloudStorageConfig();
                      myConfig.setServiceName("https://myservices.us.oraclecloud.com-a486643").setUsername("Abdulmohsen.alaiban@salic.com")
                                      .setPassword("Salic@123".toCharArray()).setServiceUrl("https://storageconsole.us2.oraclecloud.com");
                      CloudStorage myConnection = CloudStorageFactory.getStorage(myConfig);
                      FileInputStream fis = new FileInputStream("hello_world.txt");
                      myConnection.storeObject("ElementEntry", "hello_world.txt", "text/plain", fis);*/
     
        File f = null;
             boolean bool = false;
             
             try {
             
                // create new file
                f = new File("test.dat");
                 String content = "METADATA|ElementEntry|SourceSystemOwner|SourceSystemId|AssignmentNumber|EffectiveStartDate|EffectiveEndDate|ElementName|LegislativeDataGroupName|MultipleEntryCount|EntryType|CreatorType"; 
                 BufferedWriter bw =null;
                 FileWriter fw = null;
                // tries to create new file in the system
                bool = f.createNewFile();
                 String path=new File("").getAbsolutePath();
                       System.err.println("path======>"+path);
                 JSFUtils.addFacesInformationMessage("file  "+path);
                // prints
                System.out.println("File created: "+bool);
                
                // deletes file from the system
                f.delete();
                
                // delete() is invoked
                System.out.println("delete() method is invoked");
                
                // tries to create new file in the system
                bool = f.createNewFile();
                
                // print
                System.out.println("File created: "+bool);
                   System.err.println("sss-->  "+f);
                 JSFUtils.addFacesInformationMessage("file  "+f);
                 fw = new FileWriter(path+"//test.dat");
                 bw = new BufferedWriter(fw);
                        bw.write(content);
                        bw.close();
                        fw.close();

            byte[] buffer = new byte[1024];
            FileOutputStream fos =
                new FileOutputStream(path + "//ElementEntry.zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry("test.dat");
            zos.putNextEntry(ze);
            FileInputStream in =
                new FileInputStream(path + "//test.dat");

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry();

            zos.close();

            System.out.println("Done");
                 
                 String inputFile = path+"//ElementEntry.zip";
                           byte[] fileInBytes = loadFile(inputFile);
                           String fileInBase64 = DatatypeConverter.printBase64Binary(fileInBytes);
                           System.out.println(fileInBase64);
                 
                 
                 JSFUtils.addFacesInformationMessage("base64 code    "+fileInBase64);      
             } catch(Exception e) {
                e.printStackTrace();
                 JSFUtils.addFacesInformationMessage("file  "+e.getMessage());
             }
    }
    public static byte[] loadFile(String sourcePath) throws IOException
       {
         InputStream inputStream = null;
         try {
            inputStream = new FileInputStream(sourcePath);
            return readFully(inputStream);
         } finally {
             if (inputStream != null) {
               inputStream.close();
             }
          }
       }
       public static byte[] readFully(InputStream stream) throws IOException {
          byte[] buffer = new byte[8192];
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
          int bytesRead;
          while ((bytesRead = stream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
          }
           return baos.toByteArray();
        }
}
