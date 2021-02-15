export interface UserRestaurant{
    id?:number,
    mail:string,
    password:string,
    country:string,
    postcode:string,
    city:string,
    address:string
}
export interface UserLoginRequest{
    mail:string,
    password:string
}