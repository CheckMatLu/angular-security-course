export class User {

  userName: string;
  enabled: boolean;
  emailVerified: boolean;
  firstName: string;
  lastName: string;
  email: string;

  constructor(userName: string,
              enabled: boolean,
              emailVerified: boolean,
              firstName: string,
              lastName: string,
              email: string
          ) {
    this.userName = userName;
    this.enabled = (enabled) ? enabled : false;
    this.emailVerified = (emailVerified) ? emailVerified : false;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
