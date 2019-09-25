import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFindPassengerComponent } from './admin-find-passenger.component';

describe('AdminFindPassengerComponent', () => {
  let component: AdminFindPassengerComponent;
  let fixture: ComponentFixture<AdminFindPassengerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminFindPassengerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFindPassengerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
