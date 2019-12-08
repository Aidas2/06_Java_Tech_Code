class Polygon {
    constructor(height = 2, width = 3) {
        this.height = height;
        this.width = width;
    }
    get area() {
        return this.calcArea()
    }
    calcArea() {
        return this.height * this.width;
    }
}

export var P1 = Polygon;
export var P2 = Polygon
export default Polygon;