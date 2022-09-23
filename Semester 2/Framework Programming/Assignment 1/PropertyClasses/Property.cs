using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PropertyClasses
{
    public class Property
    {
        private int numOfBedrooms;
        private double numOfBathrooms;
        private String propertyType;

        public int NumOfBedrooms
        {
            get
            {
                return numOfBedrooms;
            }
            set
            {
                numOfBedrooms = value;
            }
        }

        public double NumOfBathrooms
        {
            get
            {
                return numOfBathrooms;
            }
            set
            {
                numOfBathrooms = value;
            }
        }

        public string PropertyType
        {
            get
            {
                return propertyType;
            }
            set
            {
                propertyType = value;
            }
        }

        public Property (int nbedrooms, double nbathrooms, string ptype)
        {
            NumOfBedrooms = nbedrooms;
            NumOfBathrooms = nbathrooms;
            PropertyType = ptype;

        }

        public override String ToString()
        {
            return " You have rented a " + PropertyType + " property with " + NumOfBedrooms + " bedroom(s) and " + NumOfBathrooms + " bathroom(s) ";
        }

    }
}
