using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PropertyClasses
{
    public class Buyer
    {
        private string firstName;
        private string lastName;

        public string FirstName
        {
            get
            {
                return firstName;
            }
            set
            {
                firstName = value;
            }
        }

        public string LastName
        {
            get
            {
                return lastName;
            }
            set
            {
                lastName = value;
            }
        }

        public Buyer(string fName, string lName)
        {
            FirstName = fName;
            LastName = lName;
        }

        public override String ToString()
        {
            return "Thank you " + FirstName + " " + LastName + ".";
        }
    }
}
