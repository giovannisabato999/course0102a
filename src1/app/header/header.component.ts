import { DataStoragaService } from './../shared/data-storage.service';
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {

constructor(private dataStoragaService: DataStoragaService) {}

  onSaveData(){

    this.dataStoragaService.storeRecipes();
  }



  //  @Output() featureSelected = new EventEmitter<string>();




/*  onSelect(feature: string) {
    this.featureSelected.emit(feature);
  } */
}
