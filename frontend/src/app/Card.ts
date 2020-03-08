import {CheckablePoint} from "./CheckablePoint";

export class Card {
    id: number;
    title: string;
    description: string;
    creationDate: string;
    checkablePoints: CheckablePoint[];


    constructor( title: string ="", description: string="", checkablePoints: CheckablePoint[]=[],  id: number = 1, creationDate: string = "") {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.checkablePoints = checkablePoints;
    }
}