import {Component} from "@angular/core";

@Component({
    templateUrl: './check-point.html',
    styleUrls: ['./style.css']
})
export class CheckPointLine {

    title: string;

    getTitle(): string{
        return this.title
    }
}