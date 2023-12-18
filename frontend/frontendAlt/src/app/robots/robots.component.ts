// robot-list.component.ts
import { Component, OnInit } from '@angular/core';
import { RobotService } from '../services/robot.service';

@Component({
  selector: 'app-robots',
  templateUrl: './robots.component.html',
  styleUrls: ['./robots.component.css']
})
export class RobotListComponent implements OnInit {
  robots: any[] = []; 

  constructor(private robotService: RobotService) { }

  ngOnInit(): void {
    this.loadRobots();
  }

  private loadRobots(): void {
    this.robotService.getAllRobots().subscribe(
      (robots: any[]) => {
        this.robots = robots;
      },
      (error: any) => {
        console.error('Error al cargar la lista de robots', error);
      }
    );
  }
}

