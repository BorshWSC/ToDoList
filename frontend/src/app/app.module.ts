import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from "@angular/material/card";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {CheckPointLine} from "./check-point-line.component";
import {CheckBox} from "./check-box";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
    imports: [BrowserModule, FormsModule, HttpClientModule, FormsModule, BrowserAnimationsModule, MatCardModule, MatCheckboxModule, MatFormFieldModule, MatInputModule, MatButtonModule],
    declarations: [ AppComponent, CheckPointLine, CheckBox  ],
    bootstrap:    [ AppComponent, CheckPointLine, CheckBox ]
})
export class AppModule { }