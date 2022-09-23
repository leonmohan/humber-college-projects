using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PropertyClasses
{
   public class Rent
    {
        const int BEDROOM_PRICE = 300;
        const double BATHROOM_PRICE = 75;
        const int TOWN_BASE_PRICE = 500;
        const int SEMI_BASE_PRICE = 700;
        const int DETACHED_BASE_PRICE = 1000;

        double pTypeCost;

        public String PropertyType { get; set; }
        public double NumOfBaths { get; set; }
        public int NumOfBedrooms { get; set; }
        public Buyer Buyer { get; set; }
        public Property Property { get; set; }

        public Rent(Buyer buyer, Property property)
        {
            Buyer = buyer;
            Property = property;
        }

        public double CalculateRent()
        {

            NumOfBaths = Property.NumOfBathrooms;
            NumOfBedrooms = Property.NumOfBedrooms;
            PropertyType = Property.PropertyType;

            switch (PropertyType)
            {
                case "Detached":
                    pTypeCost = DETACHED_BASE_PRICE;
                    break;
                
                case "Semi-Detached":
                    pTypeCost = SEMI_BASE_PRICE;
                    break;
                
                case "Townhouse":
                    pTypeCost = TOWN_BASE_PRICE;
                    break;
            }


            return (NumOfBedrooms * BEDROOM_PRICE) + (NumOfBaths * BATHROOM_PRICE) + pTypeCost;
        }

        public override string ToString()
        {
            return Buyer.ToString() + Property.ToString() +
                "for the monthly rent of " + CalculateRent().ToString("C") + "!";
        }
    }
}
