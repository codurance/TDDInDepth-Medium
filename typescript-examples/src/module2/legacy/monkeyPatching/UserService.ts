import { UserRepository } from './UserRepository.ts';

export class UserService {
  private userRepository: UserRepository;

  constructor() {
    this.userRepository = new UserRepository();
  }

  async getUserDetails(userId: string): Promise<string> {
    const user = await this.userRepository.fetchUserById(userId);
    return `User: ${user.name}, Age: ${user.age}`;
  }
}
