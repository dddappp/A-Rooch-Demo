// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::order_estimated_ship_date_updated {

    use moveos_std::object::ObjectID;
    use rooch_test_proj1::day::Day;
    use rooch_test_proj1::order::{Self, OrderEstimatedShipDateUpdated};
    use std::string::String;

    public fun id(order_estimated_ship_date_updated: &OrderEstimatedShipDateUpdated): ObjectID {
        order::order_estimated_ship_date_updated_id(order_estimated_ship_date_updated)
    }

    public fun order_id(order_estimated_ship_date_updated: &OrderEstimatedShipDateUpdated): String {
        order::order_estimated_ship_date_updated_order_id(order_estimated_ship_date_updated)
    }

    public fun estimated_ship_date(order_estimated_ship_date_updated: &OrderEstimatedShipDateUpdated): Day {
        order::order_estimated_ship_date_updated_estimated_ship_date(order_estimated_ship_date_updated)
    }

}