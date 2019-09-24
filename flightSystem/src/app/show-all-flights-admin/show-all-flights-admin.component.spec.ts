import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllFlightsAdminComponent } from './show-all-flights-admin.component';

describe('ShowAllFlightsAdminComponent', () => {
  let component: ShowAllFlightsAdminComponent;
  let fixture: ComponentFixture<ShowAllFlightsAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAllFlightsAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllFlightsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
