import { LocationDTO } from "./LocationDTO";
import { TypeDTO } from "./TypeDTO";

export class Apartment{
    id: number;
    type: TypeDTO;
    location: LocationDTO;
    roomsNumber: number;
    guestsNumber: number;
    forSale: boolean;
    tumbnail: string;
    title: string;
}