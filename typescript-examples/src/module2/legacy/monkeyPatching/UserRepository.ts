import { Client } from 'pg'; // PostgreSQL client

export class UserRepository {
  private client: Client;

  constructor() {
    this.client = new Client({
      connectionString: process.env.DATABASE_URL,
    });
  }

  async fetchUserById(userId: string) {
    await this.client.connect();
    const result = await this.client.query('SELECT * FROM users WHERE id = $1', [userId]);
    await this.client.end();
    return result.rows[0];
  }
}
