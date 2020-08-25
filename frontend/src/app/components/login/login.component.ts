import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { User } from 'src/app/models/users';

@Component({
    selector: 'login-form',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']

})

export class LoginComponent implements OnInit{
    parsedUser: any;
    loginForm: FormGroup;
    
    constructor(
        private userService: UserService,
        private router: Router
        ){
    }

    ngOnInit(): void {
        this.initForm();
    }

    
    onLogin(): void {
        console.log(this.loginForm.value);
        const form = JSON.stringify(this.loginForm.value);
        console.log(form);
        this.userService.login(form).subscribe(
            response => {

                
                console.log('success');
//                console.log(this.user.userId);
                
                // this.user.userId = response.userId;
                // this.user.email = response.email;
                // this.user.firstName= response.firstName;
                // this.user.lastName=response.lastName;
                
                // console.log('The response is ' + this.user);
                
                
                if (response != null) {
                    console.log('Before local storage: ')
                    localStorage.setItem('userInfo', JSON.stringify(response));
                    console.log('After local storage')
                    this.router.navigate(['/user/' + response.userId])
                    }
                    else {
                    alert('Username or password is incorrect. Please try again');
                    this.router.navigate(['/login'])
                    }
            }
        );
    }

    private initForm(): void {
        this.loginForm = new FormGroup({

            email: new FormControl(null, Validators.required),
            password: new FormControl(null, Validators.required)

        });
    }
}