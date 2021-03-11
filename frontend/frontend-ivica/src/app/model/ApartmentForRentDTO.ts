import { ContentDTO } from "./ContentDTO"
import { LocationDTO } from "./LocationDTO"
import { TypeDTO } from "./TypeDTO"

export class ApartmentForRentDTO{
    type: TypeDTO
    contents: Set<ContentDTO>
    location: LocationDTO
    roomsNumber: number
    guestsNumber: number
    price_per_night: number;
    check_in_time: string;
    check_out_time: string;
    description: string;
    keyWords: string;
}