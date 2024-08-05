using System;

namespace Collections
{
    public class User : IUser
    {
        public User(string fullName, string username, uint? age)
        {
            if (username == null)
            {
                throw new ArgumentNullException("The username can't be null");
            }
            Age = age;
            FullName = fullName;
            Username = username;
        }
        
        public uint? Age { get; }
        
        public string FullName { get; }
        
        public string Username { get; }

        public bool IsAgeDefined => Age.HasValue;

        // TODO implement missing methods (try to autonomously figure out which are the necessary methods)

        public override bool Equals(object obj)
        {
            return obj is User user &&
                   Age == user.Age &&
                   FullName == user.FullName &&
                   Username == user.Username &&
                   IsAgeDefined == user.IsAgeDefined;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(Age, FullName, Username, IsAgeDefined);
        }

        public override string ToString() => $"FullName: {FullName} Username: {Username} Age: {(IsAgeDefined ? Age : "not defined")}";
    }
}
