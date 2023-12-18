import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { RobotService } from './robot.service';

describe('RobotService', () => {
  let service: RobotService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [RobotService]
    });

    service = TestBed.inject(RobotService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get all robots', () => {
    const mockRobots = [{ id: 1, state: 'Active' }, { id: 2, state: 'Inactive' }];

    // Realiza la solicitud HTTP simulada
    service.getAllRobots().subscribe(robots => {
      expect(robots).toEqual(mockRobots);
    });

    const req = httpTestingController.expectOne('http://tu-api-backend.com/trolleys'); // Ajusta la URL según tu API
    expect(req.request.method).toEqual('GET');

    // Completa la solicitud devolviendo los robots simulados
    req.flush(mockRobots);
  });

});

