import { Injectable } from "@angular/core/src/core";
import { Http } from "@angular/http";

@Injectable()
export class ConfigService {
  constructor(private http: Http) { }
}