export class CheckablePoint{

    id: number;
    text: string;
    state: boolean;


    constructor( text: string, id: number = 1, state: boolean = false) {
        this.id = id;
        this.text = text;
        this.state = state;
    }
}