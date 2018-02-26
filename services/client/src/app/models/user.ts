export class User {
  id: string;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  authorities: string[];
  accountNonLocked: boolean;
  accountNonExpired: boolean;
  credentialsNonExpired: boolean;
  enabled: boolean;
  userRank: object;
  email: string;
  createdAt: object;
  orders: string[];
}
