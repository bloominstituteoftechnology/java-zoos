package models;

import javax.persistence.Embeddable;

public class ZooAnimalId {

    @Embeddable
    public class ZooAnimalsId implements Serializable
    {
        private long zoo;
        private long animal;


        public ZooAnimalsId()
        {
        }

        public long getZoo() {
            return zoo;
        }

        public void setZoo(long zooid) {
            this.zoo = zooid;
        }

        public long getAnimal() {
            return animal;
        }

        public void setAnimal(long animalid) {
            this.animal = animalid;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ZooAnimalsId that = (ZooAnimalsId) o;
            return zoo == that.zoo &&
                    animal == that.animal;
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }


}

