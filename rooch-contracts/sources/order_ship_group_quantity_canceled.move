// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::order_ship_group_quantity_canceled {

    use moveos_std::object_id::ObjectID;
    use rooch_test_proj1::order::{Self, OrderShipGroupQuantityCanceled};
    use std::string::String;

    public fun id(order_ship_group_quantity_canceled: &OrderShipGroupQuantityCanceled): ObjectID {
        order::order_ship_group_quantity_canceled_id(order_ship_group_quantity_canceled)
    }

    public fun order_id(order_ship_group_quantity_canceled: &OrderShipGroupQuantityCanceled): String {
        order::order_ship_group_quantity_canceled_order_id(order_ship_group_quantity_canceled)
    }

    public fun ship_group_seq_id(order_ship_group_quantity_canceled: &OrderShipGroupQuantityCanceled): u8 {
        order::order_ship_group_quantity_canceled_ship_group_seq_id(order_ship_group_quantity_canceled)
    }

    public fun product_obj_id(order_ship_group_quantity_canceled: &OrderShipGroupQuantityCanceled): ObjectID {
        order::order_ship_group_quantity_canceled_product_obj_id(order_ship_group_quantity_canceled)
    }

    public fun cancel_quantity(order_ship_group_quantity_canceled: &OrderShipGroupQuantityCanceled): u64 {
        order::order_ship_group_quantity_canceled_cancel_quantity(order_ship_group_quantity_canceled)
    }

}
