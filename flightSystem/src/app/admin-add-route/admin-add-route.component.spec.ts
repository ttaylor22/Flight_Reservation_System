import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddRouteComponent } from './admin-add-route.component';

describe('AdminAddRouteComponent', () => {
  let component: AdminAddRouteComponent;
  let fixture: ComponentFixture<AdminAddRouteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddRouteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
