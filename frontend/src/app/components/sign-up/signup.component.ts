import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';

@Component({
    selector: 'signup-form',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']

})

export class SignupComponent implements OnInit{
    userForm: FormGroup;

    constructor(){

    }

    ngOnInit(){
        this.initForm();
    }

    onSubmit(){
        console.log(this.userForm.value);
    }

    private initForm(){
        this.userForm = new FormGroup({

            'email':new FormControl(null, Validators.required),
            'password':new FormControl(null,Validators.required),
            'firstName':new FormControl(null),
            'lastName': new FormControl(null)


        });
    }
}