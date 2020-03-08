import {Component, ComponentFactoryResolver, ViewChild, ViewContainerRef} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Card} from "./Card";
import {CheckPointLine} from "./check-point-line.component";
import {CheckablePoint} from "./CheckablePoint";


@Component({
    selector: 'todolist',
    templateUrl: './app.component.html',
    styleUrls: ['./style.css']
})
export class AppComponent {

    response: any;
    cardsArray: any;
    title: string;
    description: string;
    @ViewChild('container', {read: ViewContainerRef}) container: ViewContainerRef;

    components = [];


    constructor(private componentFactoryResolver: ComponentFactoryResolver, private http: HttpClient) {
    }

    ngOnInit(){
        this.cardsArray = [];
        var that = this;
        this.http.get("http://localhost:8080/card")
            .subscribe((response)=>{
                this.response = response;
                console.log(this.response);
                this.response.forEach(function (value) {
                    that.cardsArray?.push(new Card( value.title, value.description, value.checkablePoints, value.id, value.creationDate));
                });

            })
    }

    add(){

        const componentFactory = this.componentFactoryResolver.resolveComponentFactory(CheckPointLine);
        const component = this.container.createComponent(componentFactory);
        this.components.push(component);
        console.log(this.components)
    }

    send(){
        let points = [];
        this.components.forEach(function (value) {
            points.push(new CheckablePoint(value.instance.getTitle()))
        });
        let card = new Card(this.title, this.description,points);
        console.log(card);
        let httpHeaders = new HttpHeaders({
            "Content-Type": "application/json"
        });
        let options = {
            headers: httpHeaders
        };
        let serialized = JSON.stringify(card);
        return this.http.post<Card>("http://localhost:8080/card", serialized, options).subscribe((response)=>{
            this.response = response;
            console.log(this.response);
        })
    }

    delete(card: Card){

        let serialized = JSON.stringify(card);

        const options = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
            }),
            body: serialized,
        };

        let url: string = "http://localhost:8080/card/" + card.id

        return this.http.delete<Card>(url, options).subscribe((response)=>{
            console.log(response);
        })

    }



}