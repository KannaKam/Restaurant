export interface UserRestaurant{
    id?:number,
    mail?:string,
    password?:string,
    country?:string,
    postcode?:string,
    city?:string,
    address?:string
}
export interface UserLoginRequest{
    mail:string,
    password:string
}

export interface Products{
    id?:number,
    name:string,
    description:string,
    weight:number,
    stock:number,
    price:number,
    category?:Category,
    quantity?:number
}

export interface Category{
    id?:number,
    name:string,
    description:string,
    productsList?:Products[]
}