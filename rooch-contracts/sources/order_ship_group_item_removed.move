// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::order_ship_group_item_removed {

    use moveos_std::object::ObjectID;
    use rooch_test_proj1::order::{Self, OrderShipGroupItemRemoved};
    use std::string::String;

    public fun id(order_ship_group_item_removed: &OrderShipGroupItemRemoved): ObjectID {
        order::order_ship_group_item_removed_id(order_ship_group_item_removed)
    }

    public fun order_id(order_ship_group_item_removed: &OrderShipGroupItemRemoved): String {
        order::order_ship_group_item_removed_order_id(order_ship_group_item_removed)
    }

    public fun ship_group_seq_id(order_ship_group_item_removed: &OrderShipGroupItemRemoved): u8 {
        order::order_ship_group_item_removed_ship_group_seq_id(order_ship_group_item_removed)
    }

    public fun product_obj_id(order_ship_group_item_removed: &OrderShipGroupItemRemoved): ObjectID {
        order::order_ship_group_item_removed_product_obj_id(order_ship_group_item_removed)
    }

}