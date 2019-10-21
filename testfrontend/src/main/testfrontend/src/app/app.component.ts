import { Component, Directive, OnInit, NgZone, Input } from '@angular/core';
import { FileSelectDirective, FileDropDirective, FileUploader } from 'ng2-file-upload/ng2-file-upload';
import { Http } from "@angular/http";
import { FileUploaderOptions } from "ng2-file-upload";

const URL = 'http://localhost:8091/api/';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  
})
// class FileSelectDirective
export class AppComponent implements OnInit{
    uploadedFiles: Array < File > ;
    constructor(private http: Http) {

    }
     
    ngOnInit(): void {
     
    }
    
    fileChange(element) {
        this.uploadedFiles = element.target.files;
    }
    
    upload(name,blob) {
        let formData = new FormData();
       
        var fileOfBlob = new File([blob], name);
        formData.append("file", fileOfBlob);
        
        this.http.post('http://localhost:8091/uploadServices/uploadFile', formData)
        .subscribe((response) => {
             console.log('response received is ', response);
        })
    }
    
    uploadDoc(event) {
        let lastChunksize = 0;
        var file = event[0];

        this.readFile(file, lastChunksize, this.myCallback.bind(this));

       }

       myCallback(file, lastChunksize, result) {
        lastChunksize = lastChunksize + 100000000;
        if(result) {
          //Add you logic what do you want after reading the file
          var resul=this.readFile(file, lastChunksize, this.myCallback.bind(this));        
        } else {
          ///end recursion          
        }
       }

       readFile(file,lastChunksize: number, callback) {

        var fileBlob = file.slice(lastChunksize,lastChunksize+100000000);
        if(fileBlob.size !=0) {
          let fileReader = new FileReader();
          fileReader.onloadend= (result)=>{
          return callback(file,lastChunksize,fileReader.result)
          }
          fileReader.onload = (result)=>{
              var text = fileReader.result;
              console.log('undefined');
            }
              var result=fileReader.readAsText(fileBlob);
              this.upload(file.name,fileBlob)
              
        }else {
         return callback(file,lastChunksize,false);
        }
       }
       
       
}
