import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFindUserComponent } from './admin-find-user.component';

describe('AdminFindUserComponent', () => {
  let component: AdminFindUserComponent;
  let fixture: ComponentFixture<AdminFindUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminFindUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFindUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
