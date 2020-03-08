import {Component, ComponentFactoryResolver, Input} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
    selector: 'my-check',
    templateUrl: './check-box.html',
    styleUrls: ['./style.css']
})

export class CheckBox{

    @Input() point: any;
    checked: Boolean

    ngOnInit(){
        this.checked = this.point.state
    }

    constructor(private http: HttpClient) {
    }


    check(){
        this.point.state = !this.point.state;
        console.log(this.point.state);
        let httpHeaders = new HttpHeaders({
            "Content-Type": "application/json"
        });
        let options = {
            headers: httpHeaders
        };
        let serialized = JSON.stringify(this.point);
        let url: string = "http://localhost:8080/point/" + this.point.id;
        return this.http.put(url, serialized, options).subscribe((response)=>{
            console.log(response)
        })

    }
}