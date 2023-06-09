// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::order_ship_group {
    use moveos_std::event;
    use moveos_std::object_id::ObjectID;
    use moveos_std::storage_context::StorageContext;
    use moveos_std::table::{Self, Table};
    use moveos_std::tx_context;
    use rooch_test_proj1::order_item_ship_group_association::{Self, OrderItemShipGroupAssociation};
    use std::string::String;
    friend rooch_test_proj1::order_create_logic;
    friend rooch_test_proj1::order_remove_item_logic;
    friend rooch_test_proj1::order_update_item_quantity_logic;
    friend rooch_test_proj1::order_update_estimated_ship_date_logic;
    friend rooch_test_proj1::order_add_order_ship_group_logic;
    friend rooch_test_proj1::order_add_order_item_ship_group_assoc_subitem_logic;
    friend rooch_test_proj1::order_cancel_order_ship_group_quantity_logic;
    friend rooch_test_proj1::order_remove_order_ship_group_item_logic;
    friend rooch_test_proj1::order;

    const EID_ALREADY_EXISTS: u64 = 101;
    const EID_DATA_TOO_LONG: u64 = 102;

    struct OrderItemShipGroupAssociationTableItemAdded has key {
        order_id: String,
        order_ship_group_ship_group_seq_id: u8,
        product_obj_id: ObjectID,
    }

    struct OrderShipGroup has store {
        ship_group_seq_id: u8,
        shipment_method: String,
        order_item_ship_group_associations: Table<ObjectID, OrderItemShipGroupAssociation>,
    }

    public fun ship_group_seq_id(order_ship_group: &OrderShipGroup): u8 {
        order_ship_group.ship_group_seq_id
    }

    public fun shipment_method(order_ship_group: &OrderShipGroup): String {
        order_ship_group.shipment_method
    }

    public(friend) fun set_shipment_method(order_ship_group: &mut OrderShipGroup, shipment_method: String) {
        order_ship_group.shipment_method = shipment_method;
    }

    public(friend) fun add_order_item_ship_group_association(storage_ctx: &mut StorageContext, order_id: String, order_ship_group: &mut OrderShipGroup, order_item_ship_group_association: OrderItemShipGroupAssociation) {
        let product_obj_id = order_item_ship_group_association::product_obj_id(&order_item_ship_group_association);
        table::add(&mut order_ship_group.order_item_ship_group_associations, product_obj_id, order_item_ship_group_association);
        event::emit_event(storage_ctx, OrderItemShipGroupAssociationTableItemAdded {
            order_id,
            order_ship_group_ship_group_seq_id: ship_group_seq_id(order_ship_group),
            product_obj_id,
        });
    }

    /*
    public(friend) fun remove_order_item_ship_group_association(order_ship_group: &mut OrderShipGroup, product_obj_id: ObjectID) {
        let order_item_ship_group_association = table::remove(&mut order_ship_group.order_item_ship_group_associations, product_obj_id);
        order_item_ship_group_association::drop_order_item_ship_group_association(order_item_ship_group_association);
    }
    */

    public(friend) fun borrow_mut_order_item_ship_group_association(order_ship_group: &mut OrderShipGroup, product_obj_id: ObjectID): &mut OrderItemShipGroupAssociation {
        table::borrow_mut(&mut order_ship_group.order_item_ship_group_associations, product_obj_id)
    }

    public fun borrow_order_item_ship_group_association(order_ship_group: &OrderShipGroup, product_obj_id: ObjectID): &OrderItemShipGroupAssociation {
        table::borrow(&order_ship_group.order_item_ship_group_associations, product_obj_id)
    }

    public fun order_item_ship_group_associations_contains(order_ship_group: &OrderShipGroup, product_obj_id: ObjectID): bool {
        table::contains(&order_ship_group.order_item_ship_group_associations, product_obj_id)
    }

    public(friend) fun new_order_ship_group(
        tx_ctx: &mut tx_context::TxContext,
        ship_group_seq_id: u8,
        shipment_method: String,
    ): OrderShipGroup {
        OrderShipGroup {
            ship_group_seq_id,
            shipment_method,
            order_item_ship_group_associations: table::new<ObjectID, OrderItemShipGroupAssociation>(tx_ctx),
        }
    }

    // Please note that when the hierarchical structure of entities within an aggregate exceeds three levels,
    // currently the 'drop_{entity_name}' function for entities from the second to the third-to-last level cannot be generated.
    /*
    public(friend) fun drop_order_ship_group(order_ship_group: OrderShipGroup) {
        let OrderShipGroup {
            ship_group_seq_id: _,
            shipment_method: _,
            order_item_ship_group_associations,
        } = order_ship_group;
    }

    */

}
