import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FloatSideNavComponent } from './float-side-nav.component';

describe('FloatSideNavComponent', () => {
  let component: FloatSideNavComponent;
  let fixture: ComponentFixture<FloatSideNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FloatSideNavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FloatSideNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
