// userService.test.ts
import { describe, it, expect, vi } from 'vitest';
import { UserService } from '../UserService.ts';


describe('UserService', () => {
  it('should return user details correctly', async () => {
    vi.mock('pg', () => {
      return {
        Client: class {
          connect = vi.fn();
          query = vi.fn().mockResolvedValue({
            rows: [{ id: '1', name: 'Alice', age: 30 }],
          });
          end = vi.fn();
        },
      };
    });


    const userService = new UserService();

    // Step 2: Execute the service method
    const result = await userService.getUserDetails('1');

    // Step 3: Validate the output
    expect(result).toBe('User: Alice, Age: 30');
  });
});
