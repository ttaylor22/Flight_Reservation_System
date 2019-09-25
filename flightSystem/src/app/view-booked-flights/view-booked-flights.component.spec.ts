import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewBookedFlightsComponent } from './view-booked-flights.component';

describe('ViewBookedFlightsComponent', () => {
  let component: ViewBookedFlightsComponent;
  let fixture: ComponentFixture<ViewBookedFlightsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewBookedFlightsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewBookedFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
