import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddFlightScheduleComponent } from './admin-add-flight-schedule.component';

describe('AdminAddFlightScheduleComponent', () => {
  let component: AdminAddFlightScheduleComponent;
  let fixture: ComponentFixture<AdminAddFlightScheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddFlightScheduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddFlightScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
