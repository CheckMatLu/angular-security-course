import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppAuthGuard } from '../app.authguard';
import { AdminComponent } from '../admin/admin.component';
import { UserComponent } from '../user/user.component';
import { HomeComponent } from '../home/home.component';

const appRoutes: Routes = [
  {
      path: 'admin',
      component: AdminComponent,
      canActivate: [AppAuthGuard],
      data: { roles: ['ADMIN'] }
    },
    {
      path: 'user',
      component: UserComponent,
      canActivate: [AppAuthGuard],
      data: { roles: ['USER'] }
    },
    {
      path: 'home',
      component: HomeComponent
    },
    {
      path: '**',
      redirectTo: '/'
    }
 ];


@NgModule({
  declarations: [],
  exports: [
    RouterModule
  ],
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  providers: [AppAuthGuard]
})
export class AppRoutingModule { }
