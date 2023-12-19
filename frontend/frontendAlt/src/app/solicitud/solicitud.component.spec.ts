import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestListComponent } from './solicitud.component';

describe('SolicitudComponent', () => {
  let component: RequestListComponent;
  let fixture: ComponentFixture<RequestListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RequestListComponent]
    });
    fixture = TestBed.createComponent(RequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
